import { getPembayaran, getPelanggan, getLayanan } from '..//api.js';

let pembayaranData = [];
let pelangganData = [];
let layananData = [];

async function loadPembayaranData() {
    try {
        const [pembayaranResponse,
            pelangganResponse,
            layananResponse] = await Promise.all([

            getPembayaran(),
            getPelanggan(),
            getLayanan()
        ]);

        pembayaranData = pembayaranResponse.data || [];
        pelangganData = pelangganResponse.data || [];
        layananData = layananResponse.data || [];

        renderTable(pembayaranData);
    } catch (error) {
        console.error('Error:', error);
        alert('Terjadi kesalahan saat mengambil data pembayaran');
    }
}

function renderTable(data) {
    const pembayaranList = document.getElementById('pembayaranList');
    pembayaranList.innerHTML = '';

    if (data.length === 0) {
        pembayaranList.innerHTML = `<tr><td colspan="6" style="text-align: center;">Tidak ada data transaksi pembayaran</td></tr>`;
        return;
    }

    data.forEach(pembayaran => {
        const idSeqPembayaran = pembayaran.idSeqPembayaran || '';
        const idPelanggan = pembayaran.idPelanggan || '';
        const idLayanan = pembayaran.idLayanan || '';
        const biaya = pembayaran.biayaPembayaran || 0;
        const tanggal = pembayaran.tanggal || '';

        const namaPelanggan = pembayaran.namaPelanggan || 'Tidak Diketahui';
        const jenisLayanan = pembayaran.jenisLayanan || 'Tidak Diketahui';

        const row = document.createElement('tr');
        row.innerHTML = `
            <td class="idSeqPembayaran" data-idSeqPembayaran="${idSeqPembayaran}">${idSeqPembayaran}</td>
            <td class="idPelanggan" data-idPelanggan="${idPelanggan}">${namaPelanggan}</td>
            <td class="idLayanan" data-idLayanan="${idLayanan}">${jenisLayanan}</td>
            <td>${formatRupiah(biaya)}</td>
            <td>${formatDate(tanggal)}</td>
            <td class="actions">
                <button class="update" onclick="updatePembayaran('${idSeqPembayaran}')">Edit</button>
                <button class="delete">Hapus</button>
            </td>
        `;
        pembayaranList.appendChild(row);
    });

    // Menambahkan event listener untuk tombol hapus
    const deleteButtons = document.querySelectorAll('.delete');
    deleteButtons.forEach(button => {
        button.addEventListener('click', function() {
            const row = this.closest('tr');
            const idSeqPembayaran = row.querySelector('.idSeqPembayaran').getAttribute('data-idSeqPembayaran');
            const idPelanggan = row.querySelector('.idPelanggan').getAttribute('data-idPelanggan');
            const idLayanan = row.querySelector('.idLayanan').getAttribute('data-idLayanan');
            confirmDeletePembayaran(idSeqPembayaran, idPelanggan, idLayanan);
        });
    });
}

function formatRupiah(angka) {
    return 'Rp ' + angka.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".");
}

function formatDate(dateString) {
    if (!dateString) return '-';
    const options = { year: 'numeric', month: 'long', day: 'numeric' };
    return new Date(dateString).toLocaleDateString('id-ID', options);
}

function updatePembayaran(id) {
    window.location.href = `update-pembayaran.html?id=${id}`;
}

function confirmDeletePembayaran(idSeqPembayaran, idPelanggan, idLayanan) {
    if (confirm('Apakah kamu yakin ingin menghapus transaksi pembayaran ini?')) {
        deletePembayaran(idSeqPembayaran, idPelanggan, idLayanan);
    }
}

async function deletePembayaran(idSeqPembayaran, idPelanggan, idJenisLayanan) {
    try {
        const response = await fetch('http://localhost:8080/pembayaran/deleteTransaksiPembayaran', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                idSeqPembayaran: idSeqPembayaran,
                idPelanggan: idPelanggan,
                idJenisLayanan: idJenisLayanan
            })
        });

        const result = await response.json();

        if (result.status === 200) {
            alert('Transaksi pembayaran berhasil dihapus');
            await loadPembayaranData(); // Reload tabel
        } else {
            alert('Gagal menghapus transaksi: ' + (result.message || ''));
        }
    } catch (error) {
        console.error('Error saat menghapus pembayaran:', error);
        alert('Terjadi kesalahan saat menghapus');
    }
}

// Pencarian semua kolom
document.getElementById('searchPembayaran').addEventListener('input', function (e) {
    const searchTerm = e.target.value.toLowerCase();

    const filteredData = pembayaranData.filter(pembayaran => {
        const namaPelanggan = pembayaran.namaPelanggan || 'Tidak Diketahui';
        const jenisLayanan = pembayaran.jenisLayanan || 'Tidak Diketahui';
        const biaya = pembayaran.biayaPembayaran?.toString() || '';
        const tanggal = pembayaran.tanggal || '';
        const idSeq = pembayaran.idSeqPembayaran?.toString() || '';

        const allText = `${idSeq} ${namaPelanggan} ${jenisLayanan} ${biaya} ${tanggal}`.toLowerCase();
        return allText.includes(searchTerm);
    });

    renderTable(filteredData);
});

// Load data saat halaman dibuka
loadPembayaranData();

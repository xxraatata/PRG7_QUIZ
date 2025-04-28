async function loadPembayaran() {
    const pembayaran = await fetchAPI('/api/pembayaran');
    const pelanggan = await fetchAPI('/api/pelanggan');
    const layanan = await fetchAPI('/api/layanan');

    let html = `
        <h2>Transaksi Pembayaran</h2>
        <table>
            <tr>
                <th>Pelanggan</th><th>Layanan</th><th>Biaya</th><th>Tanggal</th>
            </tr>
            ${pembayaran.map(p => `
            <tr>
                <td>${getNamaPelanggan(p.idPelanggan, pelanggan)}</td>
                <td>${getNamaLayanan(p.idJenisLayanan, layanan)}</td>
                <td>${p.biayaBayar}</td>
                <td>${p.tanggal}</td>
            </tr>
            `).join('')}
        </table>
    `;
    document.getElementById('content').innerHTML = html;
}

function getNamaPelanggan(id, pelanggan) {
    return pelanggan.find(p => p.idPelanggan === id)?.namaPelanggan || id;
}
document.addEventListener('DOMContentLoaded', () => {
    loadPelanggan();
});

async function loadPelanggan() {
    const pelanggan = await fetchAPI('/api/pelanggan');
    let html = `
        <h2>Data Pelanggan</h2>
        <button onclick="showFormPelanggan()">Tambah Pelanggan</button>
        <table>
            <tr>
                <th>ID</th><th>Nama</th><th>No HP</th><th>Aksi</th>
            </tr>
            ${pelanggan.map(p => `
            <tr>
                <td>${p.idPelanggan}</td>
                <td>${p.namaPelanggan}</td>
                <td>${p.nomorHP}</td>
                <td>
                    <button onclick="editPelanggan('${p.idPelanggan}')">Edit</button>
                    <button onclick="deletePelanggan('${p.idPelanggan}')">Hapus</button>
                </td>
            </tr>
            `).join('')}
        </table>
    `;
    document.getElementById('content').innerHTML = html;
}

function showFormPelanggan(pelanggan = null) {
    const isEdit = pelanggan !== null;
    document.getElementById('content').innerHTML = `
        <h2>${isEdit ? 'Edit' : 'Tambah'} Pelanggan</h2>
        <form onsubmit="handleSubmitPelanggan(event, ${isEdit})">
            <input type="hidden" id="idPelanggan" value="${isEdit ? pelanggan.idPelanggan : ''}">
            <label>Nama: <input type="text" id="namaPelanggan" value="${isEdit ? pelanggan.namaPelanggan : ''}" required></label>
            <label>No HP: <input type="text" id="nomorHP" value="${isEdit ? pelanggan.nomorHP : ''}" required></label>
            <button type="submit">Simpan</button>
        </form>
    `;
}

async function handleSubmitPelanggan(event, isEdit) {
    event.preventDefault();
    const data = {
        idPelanggan: document.getElementById('idPelanggan').value,
        namaPelanggan: document.getElementById('namaPelanggan').value,
        nomorHP: document.getElementById('nomorHP').value
    };

    await fetchAPI(
        `/api/pelanggan${isEdit ? `/${data.idPelanggan}` : ''}`,
        isEdit ? 'PUT' : 'POST',
        data
    );
    loadPelanggan();
}

async function deletePelanggan(id) {
    if (confirm('Hapus pelanggan ini?')) {
        await fetchAPI(`/api/pelanggan/${id}`, 'DELETE');
        loadPelanggan();
    }
}
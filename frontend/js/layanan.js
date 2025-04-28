// Struktur mirip pelanggan.js, sesuaikan dengan field layanan
async function loadLayanan() {
    const layanan = await fetchAPI('/api/layanan');
    let html = `
        <h2>Data Layanan</h2>
        <table>
            <tr><th>ID</th><th>Jenis Layanan</th><th>Biaya</th><th>Aksi</th></tr>
            ${layanan.map(l => `
            <tr>
                <td>${l.idJenisLayanan}</td>
                <td>${l.jenisLayanan}</td>
                <td>${l.biaya}</td>
                <td>
                    <button onclick="editLayanan(${l.idJenisLayanan})">Edit</button>
                    <button onclick="deleteLayanan(${l.idJenisLayanan})">Hapus</button>
                </td>
            </tr>
            `).join('')}
        </table>
    `;
    document.getElementById('content').innerHTML = html;
}
// app.js

import { getPelanggan, getLayanan, getPembayaran, createPelanggan, createLayanan, createPembayaran } from './api.js';

// Menampilkan data pelanggan
async function displayPelanggan() {
    const pelangganList = await getPelanggan();
    const listContainer = document.getElementById('pelangganList');
    listContainer.innerHTML = '';
    pelangganList.data.forEach(pelanggan => {  // Asumsi response menggunakan 'data' sebagai array hasil
        listContainer.innerHTML += `
            <div>
                <p>ID: ${pelanggan.idPelanggan}</p>
                <p>Nama: ${pelanggan.namaPelanggan}</p>
                <p>No HP: ${pelanggan.nomorHP}</p>
                <button onclick="deletePelanggan('${pelanggan.idPelanggan}')">Delete</button>
            </div>
        `;
    });
}

// Menampilkan data layanan
async function displayLayanan() {
    const layananList = await getLayanan();
    const listContainer = document.getElementById('layananList');
    listContainer.innerHTML = '';
    layananList.data.forEach(layanan => {  // Asumsi response menggunakan 'data' sebagai array hasil
        listContainer.innerHTML += `
            <div>
                <p>Jenis Layanan: ${layanan.jenisLayanan}</p>
                <p>Biaya: ${layanan.biaya}</p>
                <button onclick="deleteLayanan(${layanan.idJenisLayanan})">Delete</button>
            </div>
        `;
    });
}

// Menampilkan data pembayaran
async function displayPembayaran() {
    const pembayaranList = await getPembayaran();
    const listContainer = document.getElementById('pembayaranList');
    listContainer.innerHTML = '';
    pembayaranList.data.forEach(pembayaran => {  // Asumsi response menggunakan 'data' sebagai array hasil
        listContainer.innerHTML += `
            <div>
                <p>ID Pembayaran: ${pembayaran.pembayaranPK.idSeqPembayaran}</p>
                <p>Biaya Bayar: ${pembayaran.biayaPembayaran}</p>
                <p>Tanggal: ${pembayaran.tanggal}</p>
                <button onclick="deletePembayaran('${pembayaran.pembayaranPK.idPelanggan}', ${pembayaran.pembayaranPK.idJenisLayanan}, ${pembayaran.pembayaranPK.idSeqPembayaran})">Delete</button>
            </div>
        `;
    });
}

// Event listener untuk tombol create
document.getElementById('createPelangganBtn').addEventListener('click', async () => {
    const data = {
        idPelanggan: prompt("ID Pelanggan: "),
        namaPelanggan: prompt("Nama Pelanggan: "),
        nomorHP: prompt("Nomor HP: ")
    };
    await createPelanggan(data);
    displayPelanggan();
});

document.getElementById('createLayananBtn').addEventListener('click', async () => {
    const data = {
        jenisLayanan: prompt("Jenis Layanan: "),
        biaya: parseInt(prompt("Biaya Layanan: "))
    };
    await createLayanan(data);
    displayLayanan();
});

document.getElementById('createPembayaranBtn').addEventListener('click', async () => {
    const data = {
        pembayaranPK: {
            idPelanggan: prompt("ID Pelanggan: "),
            idJenisLayanan: prompt("ID Layanan: "),
            idSeqPembayaran: parseInt(prompt("ID Pembayaran: "))
        },
        biayaBayar: parseInt(prompt("Biaya Bayar: ")),
        tanggal: new Date().toISOString().split('T')[0]  // Mengambil tanggal saat ini
    };
    await createPembayaran(data);
    displayPembayaran();
});

// Load initial data
window.onload = function() {
    displayPelanggan();
    displayLayanan();
    displayPembayaran();
};

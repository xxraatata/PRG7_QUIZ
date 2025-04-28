// api.js

const API_URL = "http://localhost:8080";  // Ganti dengan URL API backend kamu

// Fungsi untuk mengambil data pelanggan
export async function getPelanggan() {
    const response = await fetch(`${API_URL}/pelanggan/getAllDataPelanggan`);
    return await response.json();
}

// Fungsi untuk mengambil data layanan
export async function getLayanan() {
    const response = await fetch(`${API_URL}/layanan/getAllDataLayanan`);
    return await response.json();
}

// Fungsi untuk mengambil data pembayaran
export async function getPembayaran() {
    const response = await fetch(`${API_URL}/pembayaran/getTransaksiPembayaran`);
    return await response.json();
}

// Fungsi untuk mengambil id pembayaran buat update
export async function getPembayaranById(id) {
    try {
        const response = await fetch(`http://localhost:8080/pembayaran/getPembayaranById?id=${id}`);
        const data = await response.json();

        if (response.ok) {
            return { status: 200, data: data };
        } else {
            return { status: 400, message: data.message || 'Gagal mengambil data' };
        }
    } catch (error) {
        console.error('Error fetching pembayaran by ID:', error);
        return { status: 500, message: 'Terjadi kesalahan saat mengambil data' };
    }
}

// Fungsi untuk mengirim data pelanggan baru
export async function createPelanggan(data) {
    const response = await fetch(`${API_URL}/pelanggan/savePelanggan`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    });
    return await response.json();
}

// Fungsi untuk mengirim data layanan baru
export async function createLayanan(data) {
    const response = await fetch(`${API_URL}/layanan/saveLayanan`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    });
    return await response.json();
}

// Fungsi untuk mengirim data pembayaran baru
export async function createPembayaran(data) {
    const response = await fetch(`${API_URL}/pembayaran/saveTransaksiPembayaran`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    });
    return await response.json();
}

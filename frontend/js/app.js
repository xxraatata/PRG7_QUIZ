// Load halaman dinamis
async function loadPage(page) {
    const response = await fetch(`/pages/${page}.html`);
    document.getElementById('content').innerHTML = await response.text();
}

// Fetch API dengan error handling
async function fetchAPI(url, method = 'GET', data = null) {
    try {
        const options = {
            method,
            headers: { 'Content-Type': 'application/json' }
        };
        if (data) options.body = JSON.stringify(data);

        const response = await fetch(url, options);
        if (!response.ok) throw new Error(await response.text());
        return await response.json();
    } catch (error) {
        alert(`Error: ${error.message}`);
        console.error(error);
    }
}
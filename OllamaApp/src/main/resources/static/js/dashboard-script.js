function loadPrismAssets() {
    const head = document.head;

    // Load Prism CSS
    const prismCss = document.createElement("link");
    prismCss.rel = "stylesheet";
    prismCss.href = "https://cdn.jsdelivr.net/npm/prismjs/themes/prism.css";
    head.appendChild(prismCss);


    function loadScript(src) {
        return new Promise((resolve, reject) => {
            const script = document.createElement("script");
            script.src = src;
            script.onload = resolve;
            script.onerror = reject;
            head.appendChild(script);
        });
    }


    return loadScript("https://cdn.jsdelivr.net/npm/prismjs/prism.js")
        .then(() => Promise.all([
            loadScript("https://cdn.jsdelivr.net/npm/prismjs/components/prism-java.min.js"),
            loadScript("https://cdn.jsdelivr.net/npm/prismjs/components/prism-javascript.min.js"),
            loadScript("https://cdn.jsdelivr.net/npm/prismjs/components/prism-python.min.js")
        ]));
}


function showLoader() {
    document.getElementById("loading-dots").style.display = "flex";
    return true;
}

window.addEventListener('load', function () {
    document.getElementById('loading-dots').style.display = 'none';

    const chat = document.getElementById("chat");
    if (chat) {
        chat.scrollTop = chat.scrollHeight;
    }

    const textarea = document.getElementById("input");
    if (textarea) {
        textarea.addEventListener("keydown", function (event) {
            if (event.key === "Enter") {
                event.preventDefault();
                showLoader();
                this.form.submit();
            }
        });
    }

    loadPrismAssets().then(() => {
        Prism.highlightAll();
    }).catch((err) => {
        console.error("Failed to load Prism.js:", err);
    });
});

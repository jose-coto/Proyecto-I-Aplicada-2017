function onResize() {
    var iframe = window.parent.document.getElementById('iframe');
    iframe.style.width = window.style.width;
    iframe.style.height = window.style.height;
}

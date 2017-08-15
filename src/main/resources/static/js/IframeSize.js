window.onresize = function() {
    var iframe = window.parent.document.getElementById('miIframe');
    iframe.style.width = window.style.width;
    iframe.style.height = window.style.height;
}

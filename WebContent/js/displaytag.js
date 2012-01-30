function addRowHandlers(tableId, rowClassName) {
    var previousClass = null;
    var table = document.getElementById(tableId);
    var rows = table.getElementsByTagName("tr");
    
    for (i = 1; i < rows.length; i++) {
        rows[i].onmouseover = function () {
            previousClass = this.className;
            this.className = rowClassName ;
        };

        rows[i].onmouseout = function () {
            this.className = previousClass;
        };
    }
}

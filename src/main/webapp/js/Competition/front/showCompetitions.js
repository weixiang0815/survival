const dates = document.querySelectorAll(".compDate");

$(document).ready(() => {
    formatDate(dates);
});

function formatDate(dates) {
    dates.forEach(date => {
        let date_str = date.innerHTML;
        let date_parts = date_str.split("-");
        let year = parseInt(date_parts[0]);
        let month = parseInt(date_parts[1]);
        let day = parseInt(date_parts[2]);
        let date_formatted = `${year}年${month}月${day}日`;
        date.innerHTML = date_formatted;
    })
}
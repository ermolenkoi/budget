
let deleteArticle = function showMessage(id) {

    let xhr = new XMLHttpRequest();

    xhr.open('POST', 'delArticles?id=' + id, false);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send();

    if (xhr.status === 200) {
        let article = document.getElementById("article" + id);
        article.remove();
    }

};

let updateArticle = function showMessage(id) {

    let xhr = new XMLHttpRequest();

    xhr.open('POST', 'delArticles?id=' + id, false);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send();

    if (xhr.status === 200) {
        let article = document.getElementById("article" + id);
        article.remove();
    }

};
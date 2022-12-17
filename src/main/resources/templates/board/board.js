const getStar = (i) => {
    $("#star_rating").text(`별점 : ${5 - i}`)
}
for (let i = 0; i < 5; i++) {
    $("#star")
        .append(`<input type="radio" id="star${i}" name="star" onclick="getStar(${i})">
                    <label for="star${i}"></label>`)
}
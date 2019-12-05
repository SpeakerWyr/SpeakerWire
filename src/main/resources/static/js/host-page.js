function getFilterResults() {
    let genreId = document.querySelector(".filter__genre-select").value;
    let tagId = document.querySelector(".filter__tag-select").value;
    let durationId = document.querySelector(".filter__duration-select").value;
    let speakerName = document.querySelector(".filter__speakerName").value;
    
    const resultsGoHere = document.querySelector(".search-results");

    let fetchUrl = "http://localhost:8080/filter?genreId=" + genreId + "&tagId=" + tagId + "&durationId=" + durationId + "&speakerName=" + speakerName;
        
    fetch(fetchUrl)
        .then ((response) => {
            return response.text();
        })
        .then (data => {
            resultsGoHere.innerHTML=data;
        })

}

document.getElementById("filterButton").addEventListener("click", () => {
    event.preventDefault();
    getFilterResults();
});

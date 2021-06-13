var chartDataString = decryptHtml(chartData);
var chartDataJsonArray = JSON.parse(chartDataString);

var stage =[];
var count= [];

for(var i=0;i<chartDataJsonArray.length;i++){
	stage[i] = chartDataJsonArray[i].stage;
	count[i] = chartDataJsonArray[i].projectCount;
}
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: stage,
        datasets: [{
            label: 'Test',
            backgroundColor: ["#33FFC7","#FF3333","#FFF633"],
            borderColor: 'rgb(255, 99, 132)',
            data: count
        }]
    },
    options: {
		title:{
			dispaly: true,
			text: "Project Statuses"
		}
	
}
});

function decryptHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}
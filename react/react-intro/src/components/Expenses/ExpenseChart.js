//ExpenseChart.js

import React from 'react';
import Chart from '../Chart/Chart.js'

const ExpenseChart=(props)=>{
    const chartDataPoints= [
        { label:'Jan',value:0},
        { label:'Feb',value:0},
        { label:'Mar',value:0},
        { label:'Apr',value:0},
        { label:'May',value:0},
        { label:'Jun',value:0},
        { label:'Jul',value:0},
        { label:'Aug',value:0},
        { label:'Sep',value:0},
        { label:'Oct',value:0},
        { label:'Nov',value:0},
        { label:'Dec',value:0},
    ]; 

//for-in-loop is for object, for-of-loop is for array
for(const i of props.expenses){
    const expenseMonth= i.date.getMonth(); //0 represent January

    //i.amount come from comp-call of App.js
    chartDataPoints[expenseMonth].value +=i.amount; //then u use expenseMonth as index to access the array. 
    //ex if getMonth() return 11, then ChartDataPoints[11] = Dec 
    //.value is how you access the attribute, and u add
}

return  <Chart dataPoints={chartDataPoints}/>
};


export default ExpenseChart;
//Chart.js
import ChartBar from './ChartBar';
import './Chart.css'

const Chart = (props) => {
  //transform a datapoint object to just primitive number, it's going to clone all the elements of attribute: value
  // to a array-map
  const dataPointValues=props.dataPoints.map(i=>i.value)
    //then use the math.max to find out which num is the biggest amoung all the elements in datapointvalue array-map
  const totalMax= Math.max(...dataPointValues)


  return (
    <div className="chart">
      {props.dataPoints.map((dataPoint) => (
        <ChartBar
          key={dataPoint.label }
          value={dataPoint.value}
          maxValue={totalMax}
          label={dataPoint.label}
        />
      ))}
      
    </div>
  );
};

export default Chart;
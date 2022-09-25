//Expenses.js
import React,{useState} from 'react';
import "./Expenses.css";
import Card from "../UI/Card";
import ExpensesFilter from "./ExpenseFilter";
import ExpensesList from './ExpensesList';
import ExpensesChart from './ExpenseChart';

const Expenses = (props) => {

  const [filteredYear, setFilteredYear] = useState("2020");

  //this function return a filtered List of desired year, ex only lists of year 2020
  const filteredExpenses = props.items.filter((i) => {
    return i.date.getFullYear().toString() === filteredYear;
  });


    const filterChangeHandler = (selectedYear) => {
      setFilteredYear(selectedYear);
    };

  return (
    <div>
      <Card className="expenses">
        <ExpensesFilter
          selected={filteredYear}
          onChangeFilter={filterChangeHandler}
        />

        <ExpensesChart expenses={filteredExpenses}/>
        <ExpensesList items={filteredExpenses}/>

        
      </Card>
    </div>
  );
};

export default Expenses;

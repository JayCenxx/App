// NewExpense.js
import React from 'react';
import ExpenseForm from './ExpenseForm';
import './NewExpense.css';

//the props param here ll catch the parent's function's address
const NewExpense=(props)=>{

const saveExpenseDataHandler=(data)=>{
    
    const expenseObject={
        ...data,
        id:Math.random().toString()
    };
props.onAddExpense(expenseObject);

}


    return (
        
    <div className="new-expense">
        {/* lhs is pointer, rhs is address to the function */}
        <ExpenseForm  onSaveExpenseData={saveExpenseDataHandler}  />
        </div>)
};

export default NewExpense;
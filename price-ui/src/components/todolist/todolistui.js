import React, { Fragment } from "react";
import TodoItem from "./todoitem";

const TodoListUI = props => {
  return (
    <Fragment>
      <div>
        <label htmlFor="insertArea">please input:</label>
        <input
          id="insertArea"
          value={props.inputValue}
          onChange={props.handleInputChange}
        />
        <button onClick={props.handleBtnClick}>submit</button>
        <button onClick={props.handleBtnClick2}>submit2</button>
      </div>
      <ul>
        {props.list.map((item, index) => {
          return <TodoItem key={item} content={item} index={index} />;
        })}
      </ul>
    </Fragment>
  );
};

export default TodoListUI;

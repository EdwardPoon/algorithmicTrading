import React, { Component } from "react";

import store from "../../redux/store.js";
import TodoListUI from "./todolistui.js";
import SessionTimeoutModal from "../modal/session-timeout-modal.js";

import {
  getInputChangeAction,
  addTodoItemAction2,
  addTodoItemAction3
} from "../../redux/actionCreator.js";

class TodoList extends Component {
  constructor(props) {
    super(props);
    // the UI render() function would be executed again when state or props got changed
    // when the render() of parent component got executed, the render() of children would be executed as well
    this.state = store.getState();

    this.handleBtnClick = this.handleBtnClick.bind(this);
    this.handleBtnClick2 = this.handleBtnClick2.bind(this);
    this.handleInputChange = this.handleInputChange.bind(this);
    this.handleStoreChange = this.handleStoreChange.bind(this);
    this.showModal = this.showModal.bind(this);
    store.subscribe(this.handleStoreChange);
  }
  render() {
    return (
      <div>
        <TodoListUI
          inputValue={this.state.inputValue}
          list={this.state.list}
          handleBtnClick={this.handleBtnClick}
          handleBtnClick2={this.handleBtnClick2}
          handleInputChange={this.handleInputChange}
        />
        <button onClick={this.showModal}>show modal</button>
        <SessionTimeoutModal
          id="aa"
          show={this.state.showSesstionTimeoutModalForm}
        />
      </div>
    );
  }

  handleInputChange(e) {
    const action = getInputChangeAction(e.target.value);
    store.dispatch(action);
  }
  handleStoreChange() {
    console.log("store changed");
    this.setState(store.getState());
  }
  handleBtnClick(e) {
    const action = addTodoItemAction2(store.getState().inputValue);
    store.dispatch(action);
  }
  handleBtnClick2(e) {
    const action = addTodoItemAction3(store.getState().inputValue);
    store.dispatch(action);
  }
  showModal() {
    this.setState({ showSesstionTimeoutModalForm: true });
  }
}

export default TodoList;

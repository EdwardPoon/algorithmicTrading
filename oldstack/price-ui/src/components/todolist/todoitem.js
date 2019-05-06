import React, { Component } from "react";
import PropTypes from "prop-types";
import store from "../../redux/store.js";
import { deleteTodoItemAction } from "../../redux/actionCreator.js";

class TodoItem extends Component {
  constructor(props) {
    super(props);
    this.handleClick = this.handleClick.bind(this);
  }
  render() {
    const { content, test } = this.props; // content is the param which get from parent component

    return (
      <div onClick={this.handleClick}>
        {test} - {content}
      </div>
    );
  }
  handleClick() {
    const { index } = this.props;
    const action = deleteTodoItemAction(index);
    store.dispatch(action);
  }
}

TodoItem.propTypes = {
  // PropTypes.string content must be string type, PropTypes.string.isRequired : mandatory
  content: PropTypes.oneOfType([PropTypes.number, PropTypes.string]),
  // deleteItem: PropTypes.func, // deleteItem must be a function
  index: PropTypes.number
};
TodoItem.defaultProps = {
  test: "hello world"
};
export default TodoItem;

import React, { Component, Fragment } from "react";

import { connect } from "react-redux";

class TodoList extends Component {
  render() {
    return (
      <Fragment>
        <div>
          <input id="insertArea" value={this.props.inputValue} />
          <button>submit</button>
        </div>
        <ul>
          <li>dell</li>
        </ul>
      </Fragment>
    );
  }
}
const mapStateToProps = state => {
  return {
    inputValue: state.inputValue
  };
};
// connect TodoList to state
export default connect(
  mapStateToProps,
  null
)(TodoList);

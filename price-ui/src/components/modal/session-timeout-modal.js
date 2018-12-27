import React, { Component } from "react";
import { Modal } from "react-bootstrap/lib";
import { Button } from "react-bootstrap";

class SessionTimeoutModal extends Component {
  constructor(props, context) {
    super(props, context);

    this.handleShow = this.handleShow.bind(this);
    this.handleClose = this.handleClose.bind(this);

    this.state = {
      show: false
    };
  }
  componentWillReceiveProps(nextProps) {
    this.setState({ show: nextProps.show });
  }

  handleClose() {
    this.setState({ show: false });
  }

  handleShow() {
    this.setState({ show: true });
  }

  render() {
    return (
      <Modal show={this.state.show} onHide={this.handleClose} bsSize="small">
        <Modal.Header closeButton>
          <Modal.Title>Session Expired</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <p>Your session has expired!</p>
          <p>Please log in again!</p>
        </Modal.Body>
        <Modal.Footer>
          <Button onClick={this.handleClose}>Sign out</Button>
          <Button onClick={this.handleClose}>Close</Button>
        </Modal.Footer>
      </Modal>
    );
  }
}

export default SessionTimeoutModal;

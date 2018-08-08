import React, { Component } from 'react'
import './App.css'

import axios from 'axios'

class App extends Component {
  constructor () {
    super()
    this.state = {
      averageprice: '',
	lastPriceCount:'',
	errorMessage:''
    }

    this.handleClick = this.handleClick.bind(this)
    this.handleChange = this.handleChange.bind(this);
  }
  handleChange(event) {
    const value = event.target.value;
    this.setState({
      lastPriceCount: value
    });
  }

  handleClick () {
	  var config = {
	headers: {'Access-Control-Allow-Origin': '*'}
	};
    axios.get('http://127.0.0.1:8080/securityPriceHistory/calculateAverage?securityNumber=AAPL&lastRecordCount='+this.state.lastPriceCount,config)
      .then(response => this.setState({averageprice: response.data.averagePrice,errorMessage:response.data.errorMessage}))
  }

  render () {
    return (
      <div className='button__container'>
	<label>
	 Average value of Last <input type="text" name="lastPriceCount" value={this.state.lastPriceCount} onChange={this.handleChange}/>  price
	</label>
        <button onClick={this.handleClick}>Calculate Price</button>
        <p>The average price is : {this.state.averageprice}</p>
	<p>{this.state.errorMessage}</p>
      </div>
    )
  }
}
export default App

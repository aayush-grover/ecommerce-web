import React, { Component } from 'react';
// import { Link } from "react-router-dom";
class Cart extends Component {
    state={
        cartItems:[],
        flag:true
    }
    async componentDidMount() {
        if(this.state.flag){
        const user = localStorage.getItem('username') != null ?  localStorage.getItem('username') : ' '; 
        fetch('http://localhost:8080/'+user+'/cart/items', {
          method: 'GET'
        })
          .then(response => response.json())
          .then(data => {
            if(data)
            {
                console.log(data);
                this.setState({cartItems:data,flag:false});
                console.log(this.state.cartItems);

            }
          })
        }
      }
    render() {
        return (
            <div>
                <div className="container-fluid cartbg" >
                    <h2 className="lobfont text-center pt-1">MY CART</h2>
                </div>
                <div className=" bgsocial1 border">
                    {this.state.cartItems.map((cartitem) => {
                        return(
                        <div className="mt-5 d-flex justify-content-around">
                        <div className=""><img src={cartitem.image} height="200px" width="250px" alt=".." /></div>
                        <div className="padding1"><p>{cartitem.iname}</p></div>
                        <div className="padding1"><p>{cartitem.spec}</p></div>
                        <div className="padding1"><p>Rs.{cartitem.price}</p></div>
                  </div>
                        );
                    })}
            </div> 
            </div>
        );
    }
}

export default Cart;
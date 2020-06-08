import React, { Component } from 'react';
import './Items.css';
class Items extends Component {
  state = {
    keysdata: [],
    itemdata: [],
  }

  buttonclick(image, name, specs, price) {
    console.log(image + ' ' + name + ' ' + specs + ' ' + price)

    const itemsdetail = {
      iname: name,
      image: image,
      specs: specs,
      price: price,
      username: (localStorage.getItem('username') != null ? localStorage.getItem('username') : '')
    };

    let h = new Headers();
    h.append('Content-Type', 'application/json');
    h.append('accesstoken', (localStorage.getItem('accessToken') == null) ? '' : localStorage.getItem('accessToken'));
    fetch('http://localhost:8080/cart/add', {
      method: 'POST',
      headers: h,
      body: JSON.stringify(itemsdetail),
    })
      .then(response => response.json())
      .then(data => {
        if (data) {
          if (data.code) {
            alert(data.message);
            console.log(data);
          }
          else{
            alert("Added To Cart");
            console.log(data);
            console.log(data.status);
            
          }
        }
      })

  }

  async componentDidMount() {
    fetch('http://localhost:8080/items/all', {
      method: 'GET',
    })
      .then(response => response.json())
      .then(data => {
        if (data) {
          var keys = Object.keys(data);
          var values = Object.values(data);
          this.setState({ keysdata: keys, itemdata: values });
        }
      })
  }
  render() {
    return (
      <div id="letsgo" >
        {this.state.keysdata.map((value, index) => {
          return (
            <div key={index} className="container-fluid row " style={{ "backgroundColor": "#f1f1f1" }}>
              <div className="col-12 container  mt-4">
                <h4 className="text-capitalize ">{value}</h4>
                <hr className="my-2 border-black" />
              </div>
              <div className="col-12 box container  mt-4">
                <div className="wrapper">

                  {this.state.itemdata[index].map((singleItem) => {
                    return (
                      <div key={singleItem.uuid} className="card mar" style={{ width: "18rem" }}>
                        <div className="imgbox"><img className="card-img-top item" src={singleItem.image} alt="profile" /></div>
                        <div className="card-body">
                          <div className="d-flex mb-3">
                            <h5 className="card-title w-70">{singleItem.iname}</h5>
                            <h5 className="card-title w-30 ml-auto">Rs.{singleItem.price}</h5>
                          </div>
                          <p className="card-text text-capitalize ">{singleItem.specs.length <= 20 ? singleItem.specs : singleItem.specs.substring(0, 23) + '...'}</p>
                          {localStorage.getItem('accessToken') != null ?
                            (
                              <div className="mt-2 text-center w-100">
                                <button type="button" onClick={() => this.buttonclick(singleItem.image, singleItem.iname, singleItem.specs, singleItem.price)} className=" btnset ">                     
                                  Add to Cart
                                </button>
                              </div>
                            )
                            :
                            (
                              <span></span>
                            )
                          }
                        </div>
                      </div>
                    )
                  })}

                </div>
              </div>
            </div>
          );

        })}
      </div>


    );
  }
}

export default Items;
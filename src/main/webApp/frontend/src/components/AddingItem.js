import React, { Component } from 'react';
import { Redirect } from "react-router-dom";
class AddingItem extends Component {

    state = {
        name: '',
        specs: '',
        price: 0,
        image: '',
        flag: false,

    }
    
    userChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        });
    }

    filechange = (event) => {
        event.preventDefault();
        var myHeaders = new Headers();
        myHeaders.append("Authorization", "Client-ID e27ffc1d620fce2");

        var formdata = new FormData();
        formdata.append("image", event.target.files[0]);

        var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: formdata,
            redirect: 'follow'
        };

        fetch("https://api.imgur.com/3/image", requestOptions)
            .then(response => response.json())
            .then(result => {
                this.setState({
                    image: result.data.link
                });

            })
            .catch(error => console.log('error', error));

    }

    handleFileClick = () => {
        document.getElementById('filebutton').click();
    }


    submitdata = (e) => {
        e.preventDefault();

        const itemsdetails = {
            iname: this.state.name,
            image: this.state.image,
            specs: this.state.specs,
            price: this.state.price
        };

        let h = new Headers();
            h.append('Content-Type', 'application/json');
            h.append('accesstoken', (localStorage.getItem('accessToken') == null) ? '': localStorage.getItem('accessToken'));
        fetch('http://localhost:8080/category/'+localStorage.getItem('category')+'/item/add', {
                method: 'POST',
                headers: h,
                body : JSON.stringify(itemsdetails) ,
                })
                .then(response => response.json())
                .then(data => {
                    if (data) {
                        if (data.code) {
                            alert(data.message);
                            console.log(data);
                        }
                        else {
                            alert(data.status);
                            console.log(data);
                            console.log(data.status);
                            this.setState({ flag: true });
                            console.log(data.accessToken);
                        }
                    }
                })
        
    }

    render() {
        return (
            <div>
                {this.state.flag ?
                (
                    <Redirect exact to={{
                        pathname: "/",
                    }} />
                )
            :
            (
                <div className="p-auto pt-5 categorybg1">
                <div className="container  p-auto m-auto">
                    <div className="row p-auto m-auto text-center">
                        <div className="col-12 mb-4">
                            <h2 className="lobfont  display-5 pb-3">Upload Item Details</h2>
                            <hr className="mx-4 border-3 border-dark" />
                        </div>

                        <div className="col-12 d-flex justify-content-center ">
                            <div className=" divimg rounded-circle bgitem">
                                <img className="rounded-circle"  style={{ width: '205px', height: '205px', }} src={this.state.image} />
                                <input className="itemborder bgitem" type="file" id="filebutton" onChange={this.filechange} multiple="multiple" />
                                <button className="btn btn-outline-dark inputimg font-weight-bold" onClick={this.handleFileClick} type="button">Upload Pic</button>
                            </div>
                        </div>
                        <div className="col-12 col-lg-6 mt-3">
                            <label className="font-weight-bold">Item Name:</label><br />
                            <input className="itemborder bgitem" type="text" name="name" value={this.state.name} onChange={this.userChange} /><br /><br />
                            <label className="font-weight-bold">Specifications:</label><br />
                            <textarea className="itemborder bgitem" name="specs" value={this.state.specs} onChange={this.userChange} /><br /><br />
                        </div>
                        <div className="col-12 col-lg-6 mt-3">
                            <label className="font-weight-bold">Price:</label><br />
                            <input type="number" className="itemborder bgitem text-center" name="price" value={this.state.price} onChange={this.userChange} placeholder="In Rupees" /><br /><br />
                            <button className="btn btn-dark mt-4" type="submit" onClick={this.submitdata}>Submit</button>
                        </div>
                    </div>
                </div>

                
            </div>
            )}
            </div>
        );
    }

}

export default AddingItem;
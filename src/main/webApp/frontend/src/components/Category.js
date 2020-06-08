import React, { Component } from 'react';
import { Redirect } from "react-router-dom";
class Category extends Component {
    state = {
        category: '',
        categoryuuid:'',
        // accesstoken: '',
        flag: false,
    }

    userChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value.toLowerCase()
        });
    }
    handleSubmit = (e) => {
        e.preventDefault();
        if (this.state.category !== '') {
            let h = new Headers();
            h.append('Content-Type', 'application/json');
            h.append('accesstoken', localStorage.getItem('accessToken'));
            fetch('http://localhost:8080/category/create/' + this.state.category, {
                method: 'POST',
                headers: h
            })
                .then(response => response.json())
                .then(data => {
                    if (data) {
                        if (data.code) {
                            alert(data.message);
                            this.setState({ flag: true });
                            console.log(data);
                            console.log(this.state.category)
                            localStorage.setItem('category',data.code);
                        }
                        else {
                            alert(data.status);
                            console.log(data);
                            console.log(data.status);
                            localStorage.setItem('category',data.category);
                            console.log(data.category)
                            this.setState({ flag: true , categoryuuid: data.category});
                            console.log(data.accessToken);
                        }
                    }
                })
        }
        else
            alert("fill category");
    }

    render() {
        return (
            <div>
                {this.state.flag ?
                    (
                        <Redirect exact to={{
                            pathname: "/itemdetails",
                            state: { 
                                categoryuuid : this.state.categoryuuid
                             }
                        }} />
                    )
                    :
                    (
                        <div className="categorybg text-center">
                            <div className="container-fluid row pt-5 d-flex justify-content-center">
                                <h2 className="col-12">What's the Category of Product<br /> You want to sell ?</h2>
                                <input type="text" name="category" value={this.state.category} onChange={this.userChange} required className="form-control mb-2 mr-sm-2 mt-5 col-lg-5 col-sm-12" placeholder="Category of Item..." />
                                <button onClick={this.handleSubmit} className="btn btn-dark btncategory mt-5 col-sm-12 col-lg-1" type="submit">Proceed</button>
                            </div>
                        </div>
                    )}
            </div>
        );
    }
}

export default Category;
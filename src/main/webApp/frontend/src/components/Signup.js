import React, { Component } from 'react';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import { Redirect } from "react-router-dom";
class Signup extends Component {
    state = {
        firstname: '',
        lastname: '',
        username: '',
        email: '',
        password: '',
        country: '',
        date: '',
        contactNumber: '',
        flag:true,
    }

    handleSubmit = (e) => {
        e.preventDefault();

        const user = {
            firstName: this.state.firstname,
            lastName: this.state.lastname,
            userName: this.state.username,
            email: this.state.email,
            password: this.state.password,
            country: this.state.country,
            dob: this.state.date,
            contactNumber: this.state.contactNumber
        };
        fetch('http://localhost:8080/user/signup',{
            method : 'POST',
            headers : {'Content-Type':'application/json'} ,
            body : JSON.stringify(user) ,
        })
       .then(response =>response.json())
       .then(data =>
        {
            if(data)
            {
                if(data.code)
                {
                    alert(data.message);
                    console.log(data);
                }
                else
                {
                alert("registered");
                console.log(data);
                console.log(data.status);
                }
                this.setState({flag:false});
            }
        })
    }

    userChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        });
    }

    render() {
        return (
            <div className="signupmain">
                {this.state.flag ?
             (
             <Card className="border border-dark bg-light text-black container">
                <Form onSubmit={this.handleSubmit} id="uuid">
                    <Card.Header className="text-center bg-transparent">
                        <h3>Signup</h3>
                    </Card.Header>
                    <Card.Body>
                        <Form.Row>
                            <Form.Group className="col-lg-6 col-md-12 col-sm-12">
                                <Form.Label>Firstname</Form.Label>
                                <Form.Control type="text" name="firstname" value={this.state.firstname} onChange={this.userChange} required className="bg-light text-black" placeholder="Enter your firstname" />
                            </Form.Group>
                            <Form.Group className="col-lg-6 col-md-12 col-sm-12">
                                <Form.Label>Lastname</Form.Label>
                                <Form.Control type="text" name="lastname" value={this.state.lastname} onChange={this.userChange} className="bg-light text-black" placeholder="Enter your lastname" />
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group className="col-lg-6 col-md-12 col-sm-12">
                                <Form.Label>Username</Form.Label>
                                <Form.Control type="text" name="username" value={this.state.username} onChange={this.userChange} required className="bg-light text-black" placeholder="Enter your username" />
                            </Form.Group>
                            <Form.Group className="col-lg-6 col-md-12 col-sm-12">
                                <Form.Label>Email Address</Form.Label>
                                <Form.Control type="email" name="email" value={this.state.email} onChange={this.userChange} required className="bg-light text-black" placeholder="Enter your email address" />
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group className="col-lg-6 col-md-12 col-sm-12">
                                <Form.Label>Password</Form.Label>
                                <Form.Control type="password" name="password" value={this.state.password} onChange={this.userChange} required className="bg-light text-black" placeholder="Enter Password" />
                            </Form.Group>
                            <Form.Group className="col-lg-6 col-md-12 col-sm-12">
                                <Form.Label>Country</Form.Label>
                                <Form.Control type="text" name="country" value={this.state.country} onChange={this.userChange} className="bg-light text-black" placeholder="Enter your Country" />
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group className="col-lg-6 col-md-12 col-sm-12">
                                <Form.Label>Date of Birth</Form.Label>
                                <Form.Control type="Date" name="date" value={this.state.date} onChange={this.userChange} required className="bg-light text-black" placeholder="Enter Date of birth" />
                            </Form.Group>
                            <Form.Group className="col-lg-6 col-md-12 col-sm-12">
                                <Form.Label>Contact Number</Form.Label>
                                <Form.Control type="tel" pattern="[+91-]{4}[0-9]{9,11}" name="contactNumber" value={this.state.contactNumber} onChange={this.userChange} required className="bg-light text-black" placeholder="+91-98765*****" />
                            </Form.Group>
                        </Form.Row>
                    </Card.Body>
                    <Card.Footer className="padding bg-transparent" style={{ "textAlign": "right" }}>
                        <Button  variant="primary" type="submit">
                            Submit
                    </Button>
                    </Card.Footer>
                </Form>
            </Card>
             )
             :
             (
                 <Redirect to="/login" />
             )}
            </div>
        );
    }
}

export default Signup;
import React, { Component } from 'react';
import Card from 'react-bootstrap/Card';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import { Redirect } from "react-router-dom";
class Login extends Component {
    state = {
        username: '',
        password: '',
        // accessToken: '',
        flag:true,
    }

    userChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        });
    }

    handleSubmit = (e) => {
        e.preventDefault();
        const authorisation ='Basic ' + btoa(this.state.username+ ':' +this.state.password);
        let h= new Headers();
        h.append('Content-Type','application/json');
        h.append('authorization',authorisation);
        fetch('http://localhost:8080/user/signin',{
            method : 'POST',
            headers : h 
            })
       .then(response => response.json())
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
                alert("loged in Successfully");
                console.log(data);
                console.log(data.status);
                localStorage.setItem('accessToken',data.accessToken);
                localStorage.setItem('username',data.username)
                this.setState({flag:false});
                console.log(data.accessToken);
                }
            }
        })
    }


    render() {
        return (
            <div className="loginmain">
                {this.state.flag ?
             (
            <Card className="border border-dark bg-light bgsocial1 text-black container col-lg-6 col-md-6 col-sm-12 ">
                <Form onSubmit={this.handleSubmit} id="Uuid">
                    <Card.Header className="text-center bg-transparent">
                        <h3>Login</h3>
                    </Card.Header>
                    <Card.Body>
                    <Form.Row >                       
                        <Form.Group className="col-lg-12 col-md-12 col-sm-12">
                                <Form.Label>Username</Form.Label>
                                <Form.Control type="text" name="username" value={this.state.username} onChange={this.userChange} required className="bg-light bgsocial1 text-black" placeholder="Enter your username" />
                            </Form.Group>
                            <Form.Group className="col-lg-12 col-md-12 col-sm-12">
                                <Form.Label>Password</Form.Label>
                                <Form.Control type="password" name="password" value={this.state.password} onChange={this.userChange} required className="bg-light bgsocial1 text-black" placeholder="Enter Password" />
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
                <Redirect exact to={{
                    pathname: "/",
                    // state: { accesToken: this.state.accessToken }
                }} />
            )}
            </div>
        );
    }
}

export default Login;

import React, {Component} from 'React';
import { View, Text } from 'react-native';
import {
    Container,
    Header,
    Title,
    Content,
    Button,
    Icon,
    Body,
    Left,
    Right,
    Input,
    Item,
    Form
  } from "native-base";

export default class Login extends Component{
    render(){
        return(
            <Container>
                <Content>
                    <Form>
                        <Item>
                            <Input placeholder={"Regular Textbox"}></Input>
                        </Item>
                    </Form>
                </Content>
            </Container>
        )
    }
}
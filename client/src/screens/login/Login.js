
import React, {Component} from 'React';
import {StyleSheet, View, TextInput, Dimensions, Text} from "react-native";
import {Content, Form, Item, Input,Button} from 'native-base';
import buttonStyle from '../../style/button.style';

const {height, width} = Dimensions.get("window"); //전체 스크린의 width, height를 가져온다.

export default class Login extends Component{
    // render(){
    //     return(
    //         <View style={loginScreenStyles.container}>
    //             <Text style={loginScreenStyles.title}>스터디 어플리케이션</Text>
    //             {/* <View style={loginScreenStyles.loginForm}>
    //                 <TextInput></TextInput>
    //             </View> */}
    //             <Form>
    //                 <Item>
    //                     <Input placeholder="email"></Input>
    //                 </Item>
                    
    //             </Form>
    //         </View>
            
    //     )
    // }
    render() {
        return (
            <Content style={{backgroundColor:"black"}}>
                <View style={loginScreenStyles.container}>
                    <Text style={loginScreenStyles.title}>Study Time</Text>
                    
                </View>
                <Form>
                    <Item>
                        <Input placeholder="Username" />
                    </Item>
                    <Item last>
                        <Input placeholder="Password" />
                    </Item>
                    <Button block dark onPress={()=>{alert("pressed")}}>
                        <Text style={buttonStyle.text_white}>로그인</Text>
                    </Button>
                    <Button block dark>
                        <Text style={buttonStyle.text_white}>회원가입</Text>
                    </Button>
              </Form>
              
            </Content>
        );
      }
}

const loginScreenStyles = StyleSheet.create({
    container:{
        flex : 1,
        backgroundColor : "black",
        alignItems:"center",
        justifyContent:"center"
    },
    title:{
        color:"white",
        fontSize:30,
        marginTop:40,
        fontWeight:"200", //굵기
        marginBottom: 30
    },
    loginForm:{
        backgroundColor:"white",
        flex:1,
        width: width - 25, //전체 윈도우 width -25
        borderRadius:10,
        marginBottom:30
    }
})
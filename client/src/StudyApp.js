// 2번째로 실행
// 필요한 설정이 있을 경우 추가

import React,{Component} from "React";
import { StyleSheet, Text, View } from 'react-native';
import Login from "./screens/login/Login";

export default class StudyApp extends Component{

    render(){
        return(
            <View style={styles.container}>
                <Text>Open up App.js to start working on your study app!</Text>
                <Login/>
            </View>
        )
        
    }
    
}

const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#fff',
      alignItems: 'center',
      justifyContent: 'center',
    },
  });


//가장 먼저 실행
// reducer의 store 등을 정의

import React, { Component } from "react";
import { StyleProvider, Text } from "native-base";
import { Font } from 'expo';
import { Ionicons } from '@expo/vector-icons';

import StudyApp from "./StudyApp";
// import getTheme from "../theme/components";
// import variables from "../theme/variables/commonColor";

export default class Setup extends Component {

  constructor(props){
    super(props);
    this.state = {completeSetting:false}
  }

  // // Later on in your component
  // async componentDidMount() {
  //   await Font.loadAsync({
  //     'Roboto': require('native-base/Fonts/Roboto.ttf'),
  //     'Roboto_medium': require('native-base/Fonts/Roboto_medium.ttf'),
  //     ...Ionicons.font,
  //   });
  //   this.setState({completeSetting:true})
  // }

  render() {
    return (
    //   <StyleProvider style={getTheme(variables)}>
    //     <App />
    //   </StyleProvider>
    <StudyApp/>
    );
  }
}
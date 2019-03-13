//가장 먼저 실행
// reducer의 store 등을 정의

import React, { Component } from "react";
import { StyleProvider } from "native-base";

import StudyApp from "./StudyApp";
// import getTheme from "../theme/components";
// import variables from "../theme/variables/commonColor";

export default class Setup extends Component {
  render() {
    return (
    //   <StyleProvider style={getTheme(variables)}>
    //     <App />
    //   </StyleProvider>
    <StudyApp/>
    );
  }
}
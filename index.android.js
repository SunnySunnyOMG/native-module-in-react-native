/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';
import HAHA from './my_toast';
import WebView from './my_web_view.js';

export default class nativemoduletest extends Component {
  constructor(){
    super();
    this.state = {
      showWebView:false
    }
  }
  render() {
    return (
      <View style={styles.container}>

        <Text style={styles.welcome}>
          Native module test for android
        </Text>

        <Text style={styles.instructions} onPress={()=>this._onPress1()}>
          call native module
        </Text>

        <Text style={styles.instructions} onPress={()=>this._onPress2()}>
          call native UI component
          </Text>
          {this.state.showWebView ? <WebView src111={'http://www.baidu.com/'} style={{width:400, height:500}}/> : null}
      </View>
    );
  }

  _onPress1(){
    //console.warn('1')
    HAHA.show('成功啦qweqw！！',1000, (msg)=>console.warn(msg));
  }

  _onPress2(){
    //console.warn('2')
    this.setState({showWebView:!this.state.showWebView})
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'flex-start',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
    borderWidth:2,
    padding:10
  },
});

AppRegistry.registerComponent('nativemoduletest', () => nativemoduletest);

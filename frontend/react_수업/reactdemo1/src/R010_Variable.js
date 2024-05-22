import React, { Component } from 'react';

class R010_Variable extends Component {

  constructor(props) {
    super(props);
    this.state = {};
}

// javascript - JS
// ECMA-Script - ES5, ES6
// TypeScript 
componentDidMount() {
    var varName = 'react';
    console.log('varName1 : '+varName);
    var varName = 1;
    console.log('varName2 : '+varName);

    let letName = 'react';
    console.log('letName1 : '+letName);
    letName = 'react200';
    console.log('letName2 : '+letName);

    // immutable 로 처음 넣은 값의 자료형이 유지되는 값을 넣을 수 있음.
    const constName = 'react';  // 문자형태 넣으면 값 바꿀수 없음.
    console.log('constName : ' + constName);

    let [a, b] = ['a1', 'b1'];
    console.log('a : ' + a);
    console.log('b : ' + b);

    

}

render() {
    return (
        <h2>[THIS IS Variable ]</h2>
    )
}
}

export default R010_Variable;
import React, { Component } from 'react';

class R018_PropsDatatype extends Component {
    render() {
        let obj1 = { padding: "0px", color: "red" };
        let {
            String, n1, Boolean, Array, o1, f1, BooleanTrueFalse
        } = this.props
        // let {
        //     BooleanTrueFalse
        // } = this.props;
        return (
            <div>
                <div style={{ padding: "0px", color: "red" }}>
                    <p>StringProps: {String}</p>
                    <p>NumberProps: {n1}</p>
                    <span>BooleanProps: {Boolean.toString()}</span>
                    <p>ArrayProps: {Array.toString()}</p>
                    <p>ObjectJsonProps: {JSON.stringify(o1)}</p>
                    <p>FunctionProps: {f1}</p>
                </div>
                <div style={{ padding: "0px" }}>
                    {BooleanTrueFalse ? '2. ' : '1. '}
                    {BooleanTrueFalse.toString()}
                </div>
            </div>
        )
    }
}
export default R018_PropsDatatype;
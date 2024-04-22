function func2(){
    console.log('func2 호출');
}

function func3(){
    console.log('test1.jsp에 있는 func3 호출');
}

export default()=>{
    console.log('화살표 함수');
};
export {func2, func3}
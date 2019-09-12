let address = 'http://192.168.3.235:8000/index'
function postPromise(params, path) {
    return new Promise((resolve, reject) => {
       $.ajax({
        type: "POST",
        url: address + path,
        dataType:'JSON',
        data: params,
        success: res => {
          resolve(res)
        },
        fail: rej => {
          reject(rej)
        }
      });
    })
};


function getPromise(params, path) {
    return new Promise((resolve, reject) => {
       $.ajax({
        type: "GET",
        url: address + path,
        data: params,
        dataType:'JSON',
        success: res => {
          resolve(res)
        },
        fail: rej => {
          reject(rej)
        }
      });
    })
};
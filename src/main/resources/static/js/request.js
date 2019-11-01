let address = 'http://xy-yp.natapp1.cc/'
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

function jsonPromise(params, path) {
    return new Promise((resolve, reject) => {
       $.ajax({
        type: "POST",
        url: address + path,
        data: params,
        dataType:'JSON',
        contentType: 'application/json',
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



function upFile(params, path) {
  return new Promise((resolve, reject) => {
    $.ajax({
      url: address + path,
      type: "POST",
      data: params,
      cache: false,
      contentType: false,
      processData: false,
      success: res => {
        resolve(res)
      },
      fail: rej => {
        reject(rej)
      }
    });
  })
};

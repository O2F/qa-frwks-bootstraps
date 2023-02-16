function fn() {
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env initial system property is:', env);
  if (!env) {
    env = 'dev';
  }
  //extra
  karate.configure('connectTimeout', 5000)
  karate.configure('readTimeout', 5000)
  //extra
  var config = {
    env: env,
    myVarName: 'someValue',
    baseUrl: 'https://reqres.in/api/'
  }
  if (env == 'dev') {
    // customize
    // e.g. config.foo = 'bar';
    config.baseUrl = 'https://othersite';
  } else if (env == 'e2e') {
    // customize
  }
  return config;
}
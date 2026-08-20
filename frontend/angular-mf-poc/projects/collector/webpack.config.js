const {
  shareAll,
  withModuleFederationPlugin,
} = require('@angular-architects/module-federation/webpack');

module.exports = withModuleFederationPlugin({
  name: 'collector',

  exposes: {
    './routes': './projects/collector/src/app/collector.routes.ts',
  },

  shared: {
    ...shareAll({
      singleton: true,
      strictVersion: true,
      requiredVersion: 'auto',
    }),
  },
});

module.exports.output.uniqueName = 'collector';
module.exports.output.publicPath = 'auto';
module.exports.optimization.runtimeChunk = false;
module.exports.devServer = {
  headers: {
    'Access-Control-Allow-Origin': 'http://localhost:8081',
    'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, PATCH, OPTIONS',
    'Access-Control-Allow-Headers': 'X-Requested-With, content-type, Authorization',
  },
};
const {
  shareAll,
  withModuleFederationPlugin,
} = require('@angular-architects/module-federation/webpack');

module.exports = withModuleFederationPlugin({
  remotes: {
    calculator: 'calculator@http://localhost:8082/remoteEntry.js',
    collector: 'collector@http://localhost:8083/remoteEntry.js',
  },
  shared: {
    ...shareAll({ singleton: true, strictVersion: true, requiredVersion: 'auto' }),
  },
});

module.exports.output.uniqueName = 'orchestrator';
module.exports.output.publicPath = 'auto';
module.exports.output.scriptType = 'text/javascript';
module.exports.optimization.runtimeChunk = false;
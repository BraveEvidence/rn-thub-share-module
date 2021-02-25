# rn-thub-share-module

Share Module

## Installation

```sh
npm install rn-thub-share-module
```

## Usage

```js
import RnThubShareModule from 'rn-thub-share-module';

RnThubImageLabelling.shareText(
  texttobeshared,
  (data) => {
    console.log(data);
  },
  (errorMessage) => {
    console.log(errorMessage);
  }
);

RnThubImageLabelling.shareImage(
  imageUrl,
  imageExtension,
  (data) => {
    console.log(data);
  },
  (errorMessage) => {
    console.log(errorMessage);
  }
);
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

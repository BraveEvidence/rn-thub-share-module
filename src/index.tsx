import { NativeModules } from 'react-native';

type RnThubShareModuleType = {
  multiply(a: number, b: number): Promise<number>;
};

const { RnThubShareModule } = NativeModules;

export default RnThubShareModule as RnThubShareModuleType;

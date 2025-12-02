import { SqlTableT } from '@/core/store/api/etc/types';

export type ImageT = SqlTableT<{
  url: string;
  publicId: string;
}>;

export type UserT = SqlTableT<{
  name: string;
  username: string;
  image: ImageT;
}>;

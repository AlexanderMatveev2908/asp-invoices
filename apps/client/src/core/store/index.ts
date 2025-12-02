import { noticeReducer, NoticeStateT } from '@/features/notice/reducer/reducer';
import { toastReducer, ToastStateT } from '@/features/toast/reducer/reducer';
import { ActionReducerMap } from '@ngrx/store';
import { userReducer, UserStateT } from '@/features/user/reducer/reducer';
import { wakeUpReducer, WakeUpStateT } from '@/features/wake_up/reducer/reducer';

export interface StoreStateT {
  wakeUp: WakeUpStateT;
  toast: ToastStateT;
  notice: NoticeStateT;
  user: UserStateT;
}

export const rootReducer: ActionReducerMap<StoreStateT> = {
  wakeUp: wakeUpReducer,
  toast: toastReducer,
  notice: noticeReducer,
  user: userReducer,
};

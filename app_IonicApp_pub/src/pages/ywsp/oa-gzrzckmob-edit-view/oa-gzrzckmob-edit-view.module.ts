import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { IBizSysModule } from '../../../ibizsys/ibizsys.module';
import { UserModule } from '../../user.module';
import { OA_GZRZCKMobEditView } from './oa-gzrzckmob-edit-view';




@NgModule({
  declarations: [
    OA_GZRZCKMobEditView,
  ],
  imports: [
    IonicPageModule.forChild(OA_GZRZCKMobEditView),
    IBizSysModule,
    UserModule,
  ],
})
export class OA_GZRZCKMobEditViewModule {}
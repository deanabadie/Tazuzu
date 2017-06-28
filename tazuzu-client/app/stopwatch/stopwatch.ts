import { Component, NgModule, Input, ModuleWithProviders } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { StopWatchService } from './stopwatch.service';

@Component({
    selector: 'stopwatch',
    template:
        `
        <div class="container">
          <h1>{{ formatTime(time) }}</h1>
          <div class="btn-group">
            <button class="btn btn-primary" (click)="toggle()">
              <span *ngIf="!started">Start</span>
              <span *ngIf="started">Pause</span>
            </button>
            <button class="btn btn-primary" (click)="reset()">Reset</button>
            <button class="btn btn-primary" (click)="lap()">Split</button>
          </div>
            <div class="laps"
                *ngIf="stopwatchService.laps.length > 1">
                <div class="lap"
                    *ngFor="let lap of stopwatchService.laps; let i = index; let last = last;">
                    
                    <div>Round {{ i }}</div>
                    <div>{{ formatTime(lap.startMs) }}</div>
                    <div *ngIf="last">{{ formatTime(time) }}</div>
                    <div *ngIf="!last">{{ formatTime(lap.endMs) }}</div>
                </div>
            </div>
        </div>
        `,
    styleUrls: ['./app/stopwatch/stopwatch.css']
})
export class StopWatchComponent {
    public started: boolean;
    //public stopwatchService: StopWatchService;
    public time: number;
    
    public autoStart: boolean = true;

    private timer: any;

    constructor(public stopwatchService: StopWatchService) {
        this.stopwatchService = stopwatchService;
        this.time = 0;
        this.started = false;
        if (this.autoStart) {
          this.start();
        }
    }

    formatTime(timeMs: number) {
        let minutes: string,
            seconds: string;

        minutes = Math.floor(timeMs / 60000).toString();
        seconds = ((timeMs % 60000) / 1000).toFixed(3);
        return minutes + ':' + (+seconds < 10 ? '0' : '') + seconds;
    }

    getUpdate() {
        let self = this;

        return () => {
            self.time = this.stopwatchService.time();
        };
    }

    lap() {
        this.update();

        if (this.time) {
            this.stopwatchService.lap();
        }
    }

    reset() {
        this.stopwatchService.reset();
        this.started = false;
        this.update();
    }

    start() {
        this.timer = setInterval(this.getUpdate(), 1);
        this.stopwatchService.start();
    }

    stop() {
        clearInterval(this.timer);
        this.stopwatchService.stop();
    }

    toggle() {
        if (this.started) {
            this.stop();
        } else {
            this.start();
        }

        this.started = !this.started;
    }

    update() {
        this.time = this.stopwatchService.time();
    }

    onClick() {
        console.log(this.stopwatchService);
    }
}

@NgModule({
  imports: [BrowserModule],
  exports: [StopWatchComponent],
  declarations: [StopWatchComponent]
})
export class StopWatchModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: StopWatchModule,
      providers: [StopWatchService],
    };
  }
}
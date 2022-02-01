@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">{{ __('Dashboard') }}</div>

                <div class="card-body">
                    @if (session('status'))


                    @endif

                    {{ __('You are logged in!') }}
                </div>



                <table class="table table-bordered center">
                    <tr>
                        <th>
                            <div class="col-lg-1">
                                <a class="btn btn-primary" href="{{ route('logins.index') }}">Logins</a>
                            </div>
                        </th>
                        <th>
                            <div class="col-lg-1">
                                <a class="btn btn-primary" href="{{ route('weekdays.index') }}">Weekdays</a>
                            </div>
                        </th>
                        <td>
                            <div class="col-lg-1">
                                <a class="btn btn-primary" href="{{ route('meals.index') }}">Meals</a>
                            </div>
                        </td>
                        <td>
                            <div class="col-lg-1">
                                <a class="btn btn-primary" href="{{ route('purchases.index') }}">Purchases</a>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>
@endsection
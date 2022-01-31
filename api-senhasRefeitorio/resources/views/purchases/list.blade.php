@extends('purchases.layouts.app')

@section('content')
    <div class="row">
        <div class="col-lg-11">
                <h2>Show Purchases</h2>
        </div>
        <div class="col-lg-1">
            <a class="btn btn-success" href="{{ route('purchases.create') }}">Add</a>
        </div>
    </div>

    @if ($message = Session::get('success'))
        <div class="alert alert-success">
            <p>{{ $message }}</p>
        </div>
    @endif

    <table class="table table-bordered">
        <tr>
            <th>No</th>
            <th>Meal Code</th>
            <th>User Code</th>
            <th>FlgUsed</th>



            <th width="280px">Action</th>
        </tr>
        @php
            $i = 0;
        @endphp
        @foreach ($purchases as $purchase)
            <tr>
                <td>{{ ++$i }}</td>
                <td>{{ $purchase->codMeal }}</td>
                <td>{{ $purchase->codUser }}</td>
                <td>{{ $purchase->flgUsed }}</td>

                <td>
                    <form action="{{ route('purchases.destroy',$purchase->codPurchase) }}" method="POST">
                        <a class="btn btn-info" href="{{ route('purchases.show',$purchase->codPurchase) }}">Show</a>
                        <a class="btn btn-primary" href="{{ route('purchases.edit',$purchase->codPurchase) }}">Edit</a>
                        @csrf
                        @method('DELETE')
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
        @endforeach
    </table>
@endsection
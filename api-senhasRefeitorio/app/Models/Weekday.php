<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Weekday extends Model
{
   
   
    use HasFactory;

    protected $primaryKey = 'codWeekday';

    protected $table = 'weekdays';

    protected $fillable = ['name', 'date'];

}
